package com.seuprojeto.picpaybot.adapters.outbound.playwright;

import com.microsoft.playwright.*;
import org.springframework.stereotype.Component;
import com.seuprojeto.picpaybot.domain.model.Cliente;
import com.seuprojeto.picpaybot.domain.ports.out.AutomationPort;

@Component
public class PlaywrightAutomationAdapter implements AutomationPort {

    @Override
    public boolean abrirConta(Cliente cliente) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
            Page page = browser.newPage();
            page.navigate("https://www.picpay.com/");

            // Navegar nas abas (texto usado como exemplo — valide os seletores no site real)
            try {
                page.locator("text=Para você").first().click();
                page.waitForTimeout(300);
            } catch (Exception ignored) {}
            try {
                page.locator("text=Para sua empresa").first().click();
                page.waitForTimeout(300);
            } catch (Exception ignored) {}
            try {
                page.locator("text=Sobre o PicPay").first().click();
                page.waitForTimeout(300);
            } catch (Exception ignored) {}
            try {
                page.locator("text=Central de Ajuda").first().click();
                page.waitForTimeout(300);
            } catch (Exception ignored) {}
            try {
                page.locator("text=Blog").first().click();
                page.waitForTimeout(300);
            } catch (Exception ignored) {}
            try {
                page.locator("text=Área do Cliente").first().click();
                page.waitForTimeout(300);
            } catch (Exception ignored) {}

            // Acessar Abrir Conta (selector hipotético)
            try {
                page.locator("text=Abrir Conta").first().click();
                page.waitForLoadState();
            } catch (Exception ignored) {}

            // Preencher formulário - seletores hipotéticos; adapte conforme o site real
            try {
                page.fill("input[name='cpf']", cliente.getCpf());
                page.fill("input[name='nome']", cliente.getNomeCompleto());
                page.fill("input[name='email']", cliente.getEmail());
                page.fill("input[name='celular']", cliente.getCelular());
                page.fill("input[name='dataNascimento']", cliente.getDataNascimento());
                page.click("button[type='submit']");
            } catch (Exception e) {
                // se falhar ao preencher, consideramos falha
                e.printStackTrace();
                browser.close();
                return false;
            }

            page.waitForTimeout(2000);
            boolean ok = page.locator("text=Obrigado").isVisible() || page.url().contains("/sucesso");
            browser.close();
            return ok;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
