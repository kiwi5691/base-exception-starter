package exception.exception.base;

public enum ExceptionHandlerTags {

	HANDLER_DB(0), HANDLER_EMAIL(1), HANDLER_SMS(2),EXTEND(3);

	private int tags;

	private ExceptionHandlerTags(int tags) {

		this.tags = tags;
	}

	public int valueOf() {
		return this.tags;
	}

	@Override
	public String toString() {

		return String.valueOf(this.tags);

	}

	public boolean containTo(int tags) {

		boolean contain = ((tags & this.tags) == this.tags);

		return contain;
	}
}
