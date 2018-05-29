package myapp


class Foo {

	String name

	static constraints = {
		name blank: false, unique: true
	}

}
