
import React from "react";

const courses = [
  { id: 1, name: "Angular", date: "4/5/2021" },
  { id: 2, name: "React", date: "6/3/2021" }
];

export default function CourseDetails() {
  return (
    <div>
      <h3>Course Details</h3>
      <ul>
        {courses.map(course => (
          <li key={course.id}>
            <strong>{course.name}</strong> — {course.date}
          </li>
        ))}
      </ul>
    </div>
  );
}
