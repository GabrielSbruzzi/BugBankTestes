import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BugBankTestes {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:/WebDriver/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera explícita de 10 segundos
        driver.get("https://bugbank.netlify.app/");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void cadastroUsuario(String email, String nome, String senha) {
        WebElement botaoRegistro = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]")));
        botaoRegistro.click();

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input")));
        emailInput.sendKeys(email);

        WebElement nomeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
        nomeInput.sendKeys(nome);

        WebElement senhaInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input")));
        senhaInput.sendKeys(senha);

        WebElement confirmacaoDeSenha = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwordConfirmation")));
        confirmacaoDeSenha.sendKeys(senha);

        WebElement botaoCadastrar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button")));
        botaoCadastrar.click();

        WebElement mensagemSucesso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnCloseModal\"]")));
        mensagemSucesso.click();
    }

    private void loginUsuario(String email, String senha) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[1]/input")));
        emailInput.sendKeys(email);

        WebElement senhaInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[2]/div/input")));
        senhaInput.sendKeys(senha);

        WebElement botaoEntrar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[1]")));
        botaoEntrar.click();

    }
/*
    // Método auxiliar para realizar logout
    private void logoutUsuario() {
        JavascriptExecutor botaoLogout = (JavascriptExecutor) driver;
        botaoLogout.executeScript("document.evaluate(\"//*[@id=\\\"__next\\\"]/div/div[1]/div\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();");
    }
    */

/*
    private void realizarTransferencia(String numeroConta, String digitoConta, String valor, String contaDescricao) {
        // Passo 1: Clicar no botão de Transferência
        WebElement botaoTransferir = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-TRANSFERÊNCIA")));

        // Verificar se o botão está clicável
        WebElement botaoClicavel = wait.until(ExpectedConditions.elementToBeClickable(botaoTransferir));

        // Tentar rolar até o botão, caso necessário
        Actions actions = new Actions(driver);
        actions.moveToElement(botaoClicavel).click().perform();

        // Passo 2: Preencher o campo de número da conta
        WebElement inputContaDestino = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[3]/form/div[1]/div[1]/input")));
        inputContaDestino.sendKeys(numeroConta);

        // Passo 3: Preencher o campo de dígito da conta
        WebElement inputDigito = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[3]/form/div[1]/div[2]/input")));
        inputDigito.sendKeys(digitoConta);

        // Passo 4: Preencher o valor da transferência
        WebElement inputValor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[3]/form/div[2]/input")));
        inputValor.sendKeys(valor);

        // Passo 5: Preencher a descrição da transferência
        WebElement inputDescricao = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[3]/form/div[3]/input")));
        inputDescricao.sendKeys(contaDescricao);

        // Passo 6: Confirmar a transferência
        WebElement botaoConfirmarTransferencia = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div/div[3]/form/button")));
        botaoConfirmarTransferencia.click();

        // Passo 7: Verificar se a mensagem de sucesso é exibida
        WebElement mensagemTransferencia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Transferência realizada com sucesso')]")));
        assertTrue(mensagemTransferencia.isDisplayed(), "Falha na transferência - mensagem de sucesso não exibida.");
    }
*/


    @Test
    public void testFluxoCompleto() {
        String email = "tedeusuario@gmail.com";
        String nome = "Teste Usuário";
        String senha = "12345678";
        String valorTransferencia = "50";
        String contaDestino = "123456";
        String contaDigito = "9";
        String contaDescricao = "Olá, te enviei um pix!";

        cadastroUsuario(email, nome, senha);

        loginUsuario(email, senha);

        /*
        // Passo 3: Realizar Transferência
        realizarTransferencia(contaDestino, contaDigito, valorTransferencia, contaDescricao);
        +/
         */
        // Passo 4: Logout
        /*
        logoutUsuario();
         */
    }
}
