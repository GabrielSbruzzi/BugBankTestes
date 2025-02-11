import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BugBankTestes {

    private WebDriver driver;
    private WebDriverWait wait;
    private String contaDestino;
    private String digitoDestino;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:/WebDriver/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("document.getElementById('toggleAddBalance').click();");

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

    private void logoutUsuario() {
        WebElement botaoLogout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnExit']")));
        botaoLogout.click();
    }

    public void obterDadosContaDestino() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement contaElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='textAccountNumber']")));

        String contaCompleta = contaElement.getText();

        String[] partes = contaCompleta.split("-");

        if (partes.length == 2) {
            this.contaDestino = partes[0].replaceAll("[^0-9]", "");
            this.digitoDestino = partes[1].replaceAll("[^0-9]", "");
        } else {
            throw new RuntimeException("Formato da conta inválido. Esperado: 'número-dígito'");
        }
    }

    private void realizarTransferencia(String numeroConta, String digitoConta, String valorTransferencia, String descricaoTransferencia) {
        WebElement transferenciaButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btn-TRANSFERÊNCIA']")));
        transferenciaButton.click();

        WebElement contaInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("accountNumber")));
        contaInput.sendKeys(numeroConta);

        WebElement digitoInput = driver.findElement(By.name("digit"));
        digitoInput.sendKeys(digitoConta);

        WebElement valorInput = driver.findElement(By.name("transferValue"));
        valorInput.sendKeys(valorTransferencia);

        WebElement descricaoInput = driver.findElement(By.name("description"));
        descricaoInput.sendKeys(descricaoTransferencia);

        WebElement transferirButton = driver.findElement(By.xpath("//*[@id='__next']/div/div[3]/form/button"));
        transferirButton.click();

        WebElement mensagemSucesso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='modalText']")));
        mensagemSucesso.getText();
    }

    @Test
    @Order(1)
    public void testFluxoCompleto() {
        String email1 = "tedeusuario1@gmail.com";
        String nome1 = "Teste Usuário 1";
        String senha1 = "12345678";

        String email2 = "tedeusuario2@gmail.com";
        String nome2 = "Teste Usuário 2";
        String senha2 = "87654321";

        String valorTransferencia = "50";
        String contaDescricao = "Olá, te enviei um pix!";

        cadastroUsuario(email1, nome1, senha1);

        loginUsuario(email1, senha1);

        logoutUsuario();

        cadastroUsuario(email2, nome2, senha2);

        loginUsuario(email2, senha2);

        obterDadosContaDestino();

        logoutUsuario();

        loginUsuario(email1, senha1);

        realizarTransferencia(contaDestino, digitoDestino, valorTransferencia, contaDescricao);
    }
}
