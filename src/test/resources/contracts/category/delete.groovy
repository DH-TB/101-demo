package category

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'DELETE'
        url value(consumer(regex('/categorys/\\d+')),producer('/categorys/2'))
    }
    response {
        status 204
    }
}
