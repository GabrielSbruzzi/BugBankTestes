import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class BugBankNTestes {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:/WebDriver/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://bugbank.netlify.app/");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void loginUsuarioComDadosInvalidos(String email, String senha) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[1]/input")));
        emailInput.sendKeys(email);

        WebElement senhaInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[2]/div/input")));
        senhaInput.sendKeys(senha);

        WebElement botaoEntrar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[1]")));
        botaoEntrar.click();

        try {
            WebElement erroLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Credenciais inválidas')]")));
        } catch (TimeoutException e) {
        }
    }

    private void cadastroUsuarioComDadosInvalidos(String email, String nome, String senha, String senhaConfirmacao) {
        WebElement botaoRegistro = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]")));
        botaoRegistro.click();

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input")));
        emailInput.sendKeys(email);

        WebElement nomeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
        nomeInput.sendKeys(nome);

        WebElement senhaInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input")));
        senhaInput.sendKeys(senha);

        WebElement confirmacaoDeSenha = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwordConfirmation")));
        confirmacaoDeSenha.sendKeys(senhaConfirmacao);

        WebElement botaoCadastrar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button")));
        botaoCadastrar.click();

        try {
            WebElement erroCadastro = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Erro de cadastro')]")));
        } catch (TimeoutException e) {
        }
    }

    @Test
    public void testLoginComDadosInvalidos() {
        String emailInvalido = "usuarioerrado@gmail.com";
        String senhaInvalida = "senhaerrada123";

        loginUsuarioComDadosInvalidos(emailInvalido, senhaInvalida);
    }

    @Test
    public void testCadastroComDadosInvalidos() {
        String emailInvalido = "emailerrado";
        String nome = "Teste Usuario";
        String senha = "123456";
        String senhaConfirmacao = "12345";

        cadastroUsuarioComDadosInvalidos(emailInvalido, nome, senha, senhaConfirmacao);
    }
}
