<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu - ${cafeName}</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            background-color: #f4f4f4;
        }
        h1 {
            color: #333;
        }
        .category {
            margin-top: 20px;
        }
        .item {
            margin-left: 20px;
        }
    </style>
</head>
<body>
<h1>${cafeName} Menüsü</h1>

<div class="category">
    <h2>İçecekler</h2>
    <div class="item">Çay - 15₺</div>
    <div class="item">Kahve - 40₺</div>
    <div class="item">Meyve Suyu - 30₺</div>
</div>

<div class="category">
    <h2>Yiyecekler</h2>
    <div class="item">Tost - 50₺</div>
    <div class="item">Sandviç - 75₺</div>
    <div class="item">Salata - 60₺</div>
</div>

<br><br>
<a href="/generate-qr">QR Kodunu İndir</a>
</body>
</html>