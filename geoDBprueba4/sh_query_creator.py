import json

def manage_file(filepath,out_filepath):
    out_f = open(out_filepath,'w')
    with open(filepath) as fp:
        line = fp.readline()
        for line in fp:
            # carga la línea en formato JSON
            j = json.loads(line.strip())
            # se llama al chaincode que consulta todos los tickets pertenecientes a un evento determinado
            out_f.write ("docker exec cli peer chaincode query -C mychannel -n fabcar -c '{\"function\":\"queryEvent\",\"Args\":[\"{\\\"idEvento\\\": \\\"%s\\\"}\"]}'\n" %(j['idEvent']))
manage_file('nodo2.txt','query_nodo_secundario1.sh')
manage_file('nodo3.txt','query_nodo_secundario2.sh')
