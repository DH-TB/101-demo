package cart

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'PUT'
        url value(consumer(regex('/carts/\\d+')),producer('/carts/1'))
        body("""
                  {
                          "name": "修改cart名称"
                  }
                """)
        headers {
            header('Content-Type', 'application/json;charset=UTF-8')
        }
    }
    response {
        status 204
    }
}
