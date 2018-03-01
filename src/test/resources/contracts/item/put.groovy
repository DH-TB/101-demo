package item

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'PUT'
        url value(consumer(regex('/items/\\d+')),producer('/items/1'))
        body("""
                  {
                          "name": "修改饮料名称",
                          "price":2
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
