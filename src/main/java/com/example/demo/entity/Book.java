package com.example.demo.entity;

public class Book {
	
		long id;
		String name;
		String author;

		public Book(long id, String name, String author) {
			
			super();
			this.id = id;
			this.name = name;
			this.author = author;
			System.out.println("Book entity");
		}

		public long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getAuthor() {
			return author;
		}

		@Override
		public String toString() {
			return String.format("Book [id=%s, name=%s, author=%s]", id, name, author);
		}

	
}
