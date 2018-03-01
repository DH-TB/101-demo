package item

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url value(consumer(regex('/items/\\d+')),producer('/items/1'))
    }
    response {
        status 200
        body("""
                  {
                          "id": 1,
                          "name": "饮料",
                          "price":3.00
                  }
                """)
    }
}
