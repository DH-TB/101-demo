package item

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'DELETE'
        url value(consumer(regex('/items/\\d+')),producer('/items/2'))
    }
    response {
        status 204
    }
}
