
import React from "react";


function BookItem({ book }) {
  return (
    <li key={book.id}>
      <strong>{book.title}</strong> — ₹{book.price}
    </li>
  );
}

const books = [
  { id: 1, title: "Master React", price: 670 },
  { id: 2, title: "Deep Dive into Angular 11", price: 800 },
  { id: 3, title: "Mongo Essentials", price: 450 }
];

export default function BookDetails() {
  return (
    <div>
      <h3>Book Details</h3>
      <ul>
        {books.map(book => (
          <BookItem book={book} key={book.id} />
        ))}
      </ul>
    </div>
  );
}
