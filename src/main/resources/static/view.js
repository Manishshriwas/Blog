window.onload = function() {
    fetchBlogs();
}

function fetchBlogs() {
    fetch('http://localhost:8090/api/blogs?page=0&size=10')
        .then(response => response.json())
        .then(data => {
            const blogsList = document.getElementById('blogs-list');
            blogsList.innerHTML = '';
            data.forEach(blog => {
                const blogDiv = document.createElement('div');
                blogDiv.innerHTML = `
                    <h3>${blog.title}</h3>
                    <p>${blog.content}</p>
                    <p><strong>Author:</strong> ${blog.author}</p>
                    <p><strong>Created At:</strong> ${blog.createdAt}</p>
                    <hr>
                `;
                blogsList.appendChild(blogDiv);
            });
        })
        .catch(error => console.error('Error fetching blogs:', error));
}
