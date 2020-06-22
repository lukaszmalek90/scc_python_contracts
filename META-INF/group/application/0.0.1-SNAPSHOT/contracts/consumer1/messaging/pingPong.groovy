package consumer1

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'Send a pong message in response to a ping message'
    label 'ping_pong'
    input {
        triggeredBy('triggerMessage("ping_pong")')
    }
    outputMessage {
        sentTo('output')
        body([
            message: 'pong'
        ])
    }
}
