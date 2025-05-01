document.getElementById('create-blog-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const title = document.getElementById('title').value;
    const content = document.getElementById('content').value;
    const author = document.getElementById('author').value;

    fetch('http://localhost:8090/api/blogs', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title, content, author })
    })
    .then(response => response.json())
    .then(data => {
        alert('Blog created successfully!');
    })
    .catch(error => console.error('Error:', error));
});
