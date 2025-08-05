package com.dincdev.qrmenuproject.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayOutputStream;

@Controller
public class MenuController {

    @GetMapping("/menu")
    public String showMenu(Model model) {
        model.addAttribute("cafeName", "OpenAI Cafe");
        return "menu"; // menu.jsp
    }

    @RequestMapping("/generate-qr")
    public ResponseEntity<ByteArrayResource> generateQRCode() throws Exception {
        String url = "http://localhost:8080/menu";
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(url, BarcodeFormat.QR_CODE, 250, 250);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        ByteArrayResource resource = new ByteArrayResource(pngData);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=menu-qr.png")
                .contentType(MediaType.IMAGE_PNG)
                .contentLength(pngData.length)
                .body(resource);
    }
}
