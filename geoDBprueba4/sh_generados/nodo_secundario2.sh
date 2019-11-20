docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"1111111115\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "1111111115" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"1111111115\",\"idEvento\": \"11111\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"1111111111\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "1111111111" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"1111111111\",\"idEvento\": \"11113\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111E\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111E" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111E\",\"idEvento\": \"11111\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111A\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111A" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111A\",\"idEvento\": \"11112\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111U\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111U" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111U\",\"idEvento\": \"11114\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"1111111118\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "1111111118" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"1111111118\",\"idEvento\": \"11112\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111D\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111D" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111D\",\"idEvento\": \"11114\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111G\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111G" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111G\",\"idEvento\": \"11111\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111P\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111P" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111P\",\"idEvento\": \"11112\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111H\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111H" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111H\",\"idEvento\": \"11112\",\"valid\": \"false\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111W\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111W" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111W\",\"idEvento\": \"11113\",\"valid\": \"false\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111R\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111R" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111R\",\"idEvento\": \"11111\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111K\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111K" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111K\",\"idEvento\": \"11114\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111N\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111N" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111N\",\"idEvento\": \"11113\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111M\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111M" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111M\",\"idEvento\": \"11114\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111B\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111B" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111B\",\"idEvento\": \"11113\",\"valid\": \"true\"}"]}'
fi
