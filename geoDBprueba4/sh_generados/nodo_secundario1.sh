docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111T\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111T" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111T\",\"idEvento\": \"11112\",\"valid\": \"false\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111P\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111P" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111P\",\"idEvento\": \"11112\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111S\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111S" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111S\",\"idEvento\": \"11112\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111W\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111W" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111W\",\"idEvento\": \"11113\",\"valid\": \"false\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"1111111113\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "1111111113" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"1111111113\",\"idEvento\": \"11111\",\"valid\": \"false\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111M\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111M" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111M\",\"idEvento\": \"11114\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111H\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111H" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111H\",\"idEvento\": \"11112\",\"valid\": \"false\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111C\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111C" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111C\",\"idEvento\": \"11112\",\"valid\": \"false\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111F\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111F" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111F\",\"idEvento\": \"11112\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"1111111114\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "1111111114" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"1111111114\",\"idEvento\": \"11111\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"1111111118\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "1111111118" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"1111111118\",\"idEvento\": \"11112\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111A\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111A" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111A\",\"idEvento\": \"11112\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111B\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111B" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111B\",\"idEvento\": \"11113\",\"valid\": \"true\"}"]}'
fi
docker exec cli peer chaincode query -C mychannel -n fabcar -c '{"function":"queryTicket","Args":["{\"idTicket\": \"111111111G\"}"]}'
if [ $? -eq 0 ]; then
    echo idTicket: "111111111G" already in ledger
else
docker exec cli peer chaincode invoke -C mychannel -n fabcar -c '{"function":"createTicket","Args":["{\"idTicket\": \"111111111G\",\"idEvento\": \"11111\",\"valid\": \"true\"}"]}'
fi
