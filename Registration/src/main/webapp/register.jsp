
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
<style>
    body {
    background: url('https://www.pixelstalk.net/wp-content/uploads/2016/08/Beautiful-nature-cool-images-background-hd.jpg') no-repeat center center fixed; 
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
    color: white;
    font-family: Arial, sans-serif;
}

form {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 300px;
    padding: 30px; 
    border: 1px solid white;
    border-radius: 5px;
}

label {
    display: block;
    margin-bottom: 5px;
}

input[type="text"], input[type="email"], input[type="password"], select {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: none;
    border-radius: 5px;
    background-color: #333;
    color: white;
}

input[type="radio"] {
    margin-right: 5px;
}

button {
    width: 100%;
    padding: 10px;
    border: none;
    border-radius: 5px;
    background-color: #555;
    color: white;
    cursor: pointer;
}

button:hover {
    background-color: #777;
}
</style>
</head>
<body>
    <form action="Registration-form" method="POST" method="get">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <label for="city">City:</label>
        <select id="city" name="city">
            <option value="mumbai">Mumbai</option>
            <option value="bangalore">Bangalore</option>
        </select><br>

        <label>Gender:</label>
        <input type="radio" id="male" name="gender" value="male" required>
        <label for="male">Male</label>
        <input type="radio" id="female" name="gender" value="female" required>
        <label for="female">Female</label><br>

        <button type="submit">Register</button>
    </form>
</body>
</html>