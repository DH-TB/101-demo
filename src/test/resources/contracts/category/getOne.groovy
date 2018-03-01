package category

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url value(consumer(regex('/categorys/\\d+')),producer('/categorys/1'))
    }
    response {
        status 200
        body("""
                  {
                          "id": 1,
                          "name": "饮料"
                  }
                """)
    }
}
