package org.fbpict


import org.fbpict.config.Application
import org.fbpict.entity.FBGroup
import org.fbpict.entity.FBGroupStatus
import org.fbpict.entity.FBGroupsRepository
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.junit4.SpringRunner
import java.text.SimpleDateFormat

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [Application::class])
@Import(Application::class)
class JPATests {

    @Autowired lateinit var fbGroupsRepository: FBGroupsRepository

    @Test
    fun exampleTest() {
        fbGroupsRepository.save(FBGroup("1","1","1",  SimpleDateFormat("YYYY").parse("2000"), FBGroupStatus.CHECKED))
    }

    @After
    fun clean() {
        fbGroupsRepository.delete("1")
    }

}