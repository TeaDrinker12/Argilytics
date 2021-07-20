const express = require('express');
app = express();

app.use(express.json());
app.post("/reading", (req, res) => {
    if (!req.body.timestamp) {
        return res.status(500).json({fail: "Timestamp not present"});
    }
    if (!req.body.temprature) {
        return res.status(500).json({fail: "Temprature not present"});
    }
    const reading = {
        timestamp: new Date(req.body.timestamp),
        temprature: req.body.temprature,
    }
    console.log("POST /reading: ");
    console.log(reading);
    return res.status(201).json(reading);
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