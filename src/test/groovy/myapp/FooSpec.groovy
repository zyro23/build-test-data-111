package myapp

import grails.buildtestdata.BuildDataTest
import grails.buildtestdata.mixin.Build
import grails.testing.gorm.DomainUnitTest
import grails.validation.ValidationException
import spock.lang.Specification

@Build(Foo)
class FooSpec extends Specification implements DomainUnitTest<Foo>, BuildDataTest {

	def "test blank 'x' vs. unique constraint"() {
		when:
		Foo.build()
		Foo.build()
		Foo.build()
		currentSession.flush()

		then:
		def e = thrown(ValidationException)
		e.errors.getFieldError("name").rejectedValue == "name"
	}

}
