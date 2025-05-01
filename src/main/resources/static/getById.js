function fetchBlogById() {
  const id = document.getElementById("blog-id").value;
  const outputDiv = document.getElementById("blog-details");
  outputDiv.innerHTML = "Loading...";

  fetch(`http://localhost:8090/api/blogs/${id}`)
    .then(response => {
      if (!response.ok) {
        throw new Error("Blog not found.");
      }
      return response.json();
    })
    .then(blog => {
      outputDiv.innerHTML = `
        <div class="blog-item">
          <h3>${blog.title}</h3>
          <p>${blog.content}</p>
          <p class="author"><strong>Author:</strong> ${blog.author}</p>
          <p class="date"><strong>Created at:</strong> ${new Date(blog.createdAt).toLocaleString()}</p>
        </div>
      `;
    })
    .catch(error => {
      outputDiv.innerHTML = `<p class="error">${error.message}</p>`;
    });
}
