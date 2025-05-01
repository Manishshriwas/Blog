function updateBlog() {
    const id = document.getElementById('update-id').value;
    const title = document.getElementById('update-title').value;
    const content = document.getElementById('update-content').value;
    const author = document.getElementById('update-author').value;

    fetch(`http://localhost:8090/api/blogs/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title, content, author })
    })
    .then(response => response.json())
    .then(data => {
        alert('Blog updated successfully!');
    })
    .catch(error => console.error('Error updating blog:', error));
}
