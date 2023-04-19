package consumer1

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'Send a pong message in response to a ping message'
    label 'ping_pong'
    input {
        // You have to provide the `triggerMessage` method with the `label`
        // as a String parameter of the method
        triggeredBy('triggerMessage("ping_pong")')
    }
    outputMessage {
        sentTo('output')
        body([
            message: 'pong'
        ])
    }
    metadata(
        [
         [
           outputMessage: [
               connectToBroker: [
                   declareQueueWithName: "queue"
               ],
                messageProperties: [
                    receivedRoutingKey: '#'
                ]
           ]
         ]
        ])
}
