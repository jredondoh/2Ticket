import json

def manage_file(filepath,out_filepath):
    out_f = open(out_filepath,'w')
    with open(filepath) as fp:
        line = fp.readline()
        for line in fp:
            j = json.loads(line.strip())
            out_f.write ("docker exec cli peer chaincode query -C mychannel -n fabcar -c '{\"function\":\"queryTicket\",\"Args\":[\"{\\\"idTicket\\\": \\\"%s\\\"}\"]}'\n" %(j['idTicket']))
            out_f.write("if [ $? -eq 0 ]; then\n")
            out_f.write('    echo idTicket: "%s" already in ledger\n' % (j['idTicket']))
            out_f.write('else\n')
            out_f.write ("docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{\"function\":\"createTicket\",\"Args\":[\"{\\\"idTicket\\\": \\\"%s\\\",\\\"idEvento\\\": \\\"%s\\\",\\\"valid\\\": \\\"%s\\\"}\"]}'\n" %(j['idTicket'],j['idEvent'],j['valid']))
            out_f.write('fi\n')
manage_file('nodo2.txt','nodo_secundario1.sh')
manage_file('nodo3.txt','nodo_secundario2.sh')
