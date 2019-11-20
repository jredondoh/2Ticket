import { Chaincode, Helpers, NotFoundError, StubHelper } from '@theledger/fabric-chaincode-utils';
import * as Yup from 'yup';

export class MyChaincode extends Chaincode {

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
    async queryAll(stubHelper: StubHelper, args: string[]): Promise<any> {

        return stubHelper.getQueryResultAsList(
            { selector: { docType: 'ticket' } }
        );
    }
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