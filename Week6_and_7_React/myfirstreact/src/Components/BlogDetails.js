
import React from "react";

const blogs = [
  {
    id: 1,
    title: "React Learning",
    author: "Stephen Biz",
    content: "Welcome to learning React!"
  },
  {
    id: 2,
    title: "Installation",
    author: "Schewzdenier",
    content: "You can install React from npm."
  }
];

export default function BlogDetails() {
  return (
    <div>
      <h3>Blog Details</h3>
      {blogs.map(blog => (
        <div key={blog.id} style={{ marginBottom: 10 }}>
          <h4>{blog.title}</h4>
          <small>By {blog.author}</small>
          <p>{blog.content}</p>
        </div>
      ))}
    </div>
  );
}
