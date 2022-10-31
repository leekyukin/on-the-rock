package com.kyukin.ontherock.global.annotation

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Transactional(readOnly = true)
@Service
annotation class ServiceWithTransactionalReadOnly()
