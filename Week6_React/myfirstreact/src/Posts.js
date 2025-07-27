
import React from 'react';
import Post from './Components/Post';

class Posts extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            posts: [],
            hasError: false // Add error state
        };
    }

    loadPosts() {
        // Example: Simulate loading posts (in real life, may come from API)
        const posts = [
            new Post(1, "Hello World", "This is my first post!"),
            new Post(2, "React is Awesome", "React makes it painless to create UIs."),
            new Post(3, "Lifecycle Methods", "Learning about lifecycle methods in React.")
        ];
        this.setState({ posts });
    }

    componentDidMount() {
        this.loadPosts();
    }

    // Error Boundary method for error handling
    componentDidCatch(error, info) {
        // Display the error as an alert
        alert("An error occurred: " + error);
        // You may also want to log error details or update state
        this.setState({ hasError: true });
    }

    render() {
        // If an error was caught, display a fallback message
        if (this.state.hasError) {
            return <h2>Something went wrong! Please try again later.</h2>;
        }
        return (
            <div>
                <h2>Posts</h2>
                <ul>
                    {this.state.posts.map(post => (
                        <li key={post.id}>
                            <h3>{post.title}</h3>
                            <p>{post.body}</p>
                        </li>
                    ))}
                </ul>
            </div>
        );
    }
}

export default Posts;
