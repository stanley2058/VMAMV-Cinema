package contracts

import org.springframework.cloud.contract.spec.Contract
[
        Contract.make {
            description ("notification Contract")
            name ("ordering_newNotification")
            request {
                method ("GET")
                url("/newNotification") {
                    queryParameters {
                        parameter("userID", "1")
                        parameter("content", "ordering Successfully")
                    }
                }
            }
            response {
                body("success")
                status (200)
            }
        }
]