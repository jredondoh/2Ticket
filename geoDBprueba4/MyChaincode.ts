/**
 * @file: MyChaincode.ts
 * @brief: Clase que proporciona la inicialización e interfaz frente a los nodos secundarios del
 *         nodo primario.
 * @author: Jose Redondo Hurtado
 */
import { Chaincode, Helpers, NotFoundError, StubHelper } from '@theledger/fabric-chaincode-utils';
import * as Yup from 'yup';

/**
 * Clase que proporciona la inicialización e interfaz frente a los nodos secundarios del nodo 
 * primario.
 */
export class MyChaincode extends Chaincode {

    /**
     * Inicializa la base de datos con la información del nodo primario.
     * 
     * @param stubHelper Objeto para comprobar la validez de los argumentos
     * @param args No usado en este método
     */
    async initLedger(stubHelper: StubHelper, args: string[]) {

        let tixArr = [
            { idTicket: "1111111115", idEvent: "11111", valid: "true" }
            , { idTicket: "111111111B", idEvent: "11113", valid: "true" }
            , { idTicket: "1111111117", idEvent: "11111", valid: "true" }
            , { idTicket: "1111111118", idEvent: "11112", valid: "true" }
            , { idTicket: "111111111C", idEvent: "11112", valid: "false" }
            , { idTicket: "111111111Q", idEvent: "11114", valid: "false" }
            , { idTicket: "111111111N", idEvent: "11113", valid: "true" }
            , { idTicket: "111111111J", idEvent: "11113", valid: "true" }
            , { idTicket: "111111111R", idEvent: "11111", valid: "true" }
            , { idTicket: "111111111L", idEvent: "11114", valid: "true" }
            , { idTicket: "111111111P", idEvent: "11112", valid: "true" }
            , { idTicket: "111111111G", idEvent: "11111", valid: "true" }
            , { idTicket: "111111111U", idEvent: "11114", valid: "true" }
            , { idTicket: "111111111M", idEvent: "11114", valid: "true" }
            , { idTicket: "111111111W", idEvent: "11113", valid: "false" }
            , { idTicket: "1111111114", idEvent: "11111", valid: "true" }
            , { idTicket: "111111111F", idEvent: "11112", valid: "true" }
            , { idTicket: "1111111116", idEvent: "11113", valid: "true" }
            , { idTicket: "1111111112", idEvent: "11114", valid: "true" }
            , { idTicket: "1111111111", idEvent: "11113", valid: "true" }
            , { idTicket: "1111111119", idEvent: "11112", valid: "false" }
        ];

        for (let i = 0; i < tixArr.length; i++) {
            const tix: any = tixArr[i];

            tix.docType = 'ticket';
            await stubHelper.putState(tix.idTicket, tix);
            this.logger.info('Added <--> ', tix);
        }
    }

    /**
     * Método para consultar en la base de datos un ticket mediante un idTicket.
     * 
     * @param stubHelper Objeto para comprobar la validez de los argumentos
     * @param args String en formato JSON con el idTicket que se quiere consultar
     */
    async queryTicket(stubHelper: StubHelper, args: string[]): Promise<any> {

        const verifiedArgs = await Helpers.checkArgs<{ idTicket: string }>(args[0], Yup.object()
            .shape({
                idTicket: Yup.string().required(),
            }));

        const tix = await stubHelper.getStateAsObject(verifiedArgs.idTicket);
        if (!tix) {
            throw new NotFoundError('Ticket does not exist');
        }

        return tix;
    }

    /**
     * Crea un ticket con la información pasada en formato JSON.
     * 
     * @param stubHelper Objeto para comprobar la validez de los argumentos
     * @param args String en formato JSON con toda la información del ticket
     */
    async createTicket(stubHelper: StubHelper, args: string[]) {
        const verifiedArgs = await Helpers.checkArgs<any>(args[0], Yup.object()
            .shape({
                idTicket: Yup.string().required(),
                idEvento: Yup.string().required(),
                valid: Yup.string().required()
            }));

        let tix = {
            docType: 'ticket',
            idTicket: verifiedArgs.idTicket,
            idEvento: verifiedArgs.idEvento,
            valid: verifiedArgs.valid,
        };

        await stubHelper.putState(verifiedArgs.idTicket, tix);
    }
    /**
     * Método de depuración que devuelve todo el contenido de la base de datos.
     * 
     * @param stubHelper Objeto para comprobar la validez de los argumentos
     * @param args No usado en este método
     */
    async queryAll(stubHelper: StubHelper, args: string[]): Promise<any> {

        return stubHelper.getQueryResultAsList(
            { selector: { docType: 'ticket' } }
        );
    }
    /**
     * Método para consultar en la base de datos todos los tickets de un evento por un idEvento.
     * 
     * @param stubHelper Objeto para comprobar la validez de los argumentos
     * @param args String en formato JSON con el idEvento que se quiere consultar
     */
    async queryEvent(stubHelper: StubHelper, args: string[]): Promise<any> {
        const verifiedArgs = await Helpers.checkArgs<any>(args[0], Yup.object()
            .shape({
                idEvento: Yup.string().required()
            }));

        return stubHelper.getQueryResultAsList(
            { selector: { idEvento: verifiedArgs.idEvento } }
        );
    }
}