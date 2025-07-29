import React, { useState } from "react";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

function BloggerApp() {
  const [view, setView] = useState("books"); // Default view

  let element;
  if (view === "books") {
    element = <BookDetails />;
  } else if (view === "blogs") {
    element = <BlogDetails />;
  } else if (view === "courses") {
    element = <CourseDetails />;
  } else {
    element = (
      <>
        <BookDetails />
        <BlogDetails />
        <CourseDetails />
      </>
    );
  }

  return (
    <div style={{ fontFamily: "Arial", margin: 20 }}>
      <h2>📝 Blogger App</h2>
      <div style={{ marginBottom: 20 }}>
        <button onClick={() => setView("books")}>Show Books</button>
        <button onClick={() => setView("blogs")}>Show Blogs</button>
        <button onClick={() => setView("courses")}>Show Courses</button>
        <button onClick={() => setView("all")}>Show All</button>
      </div>
      {element}
      {view !== "blogs" ? <p>Not viewing blogs</p> : null}
      {view === "courses" && <p>(Currently viewing only courses)</p>}
    </div>
  );
}

export default BloggerApp;
