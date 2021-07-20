const express = require('express');
app = express();

app.use(express.json());
app.post("/reading", (req, res) => {
    return res.status(404).json(req.body);
});
app.use((req, res) => {
    return res.status(404).json({
        fail: "Not Found"
    });
});

const port = 9000
app.listen(9000, () => {
    console.log(`Gateway API server is running http://localhost:${port}/`);
});