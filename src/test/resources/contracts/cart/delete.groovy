package cart

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'DELETE'
        url value(consumer(regex('/carts/\\d+')),producer('/carts/2'))
    }
    response {
        status 204
    }
}
