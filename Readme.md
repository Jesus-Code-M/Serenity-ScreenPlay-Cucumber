<h1 align="center"> Proyecto de Automatización: Formulario de Práctica </h1>

<p>Este proyecto implementa pruebas automatizadas para el formulario de práctica en el sitio DemoQA utilizando Serenity BDD con el patrón Screenplay y Cucumber.</p>

<h2>Estructura del Proyecto</h2>
<p>La jerarquía del proyecto se divide en varios paquetes y clases:</p>

<h3>1. Interacciones (<code>interactions</code>)</h3>
<ul>
    <li><strong>PracticeFormInteractions:</strong>
        <ul>
            <li><code>enterFirstName</code>: Ingresa el primer nombre.</li>
            <li><code>enterLastName</code>: Ingresa el apellido.</li>
            <li><code>enterEmailUsuario</code>: Ingresa el correo electrónico.</li>
            <li><code>enterNumeroTelefono</code>: Ingresa el número de teléfono.</li>
        </ul>
    </li>
</ul>

<h3>2. Preguntas (<code>questions</code>)</h3>
<ul>
    <li><strong>PracticeFormQuestions:</strong>
        <ul>
            <li><code>isVisible</code>, <code>isPresent</code>, <code>isEnabled</code>: Verifican visibilidad, presencia y habilitación de elementos.</li>
            <li><code>textEquals</code>, <code>textContains</code>: Validan el texto de los elementos.</li>
            <li>Otras preguntas personalizadas.</li>
        </ul>
    </li>
</ul>

<h3>3. Tareas (<code>tasks</code>)</h3>
<ul>
    <li><strong>PracticeFormTasks:</strong>
        <ul>
            <li><code>openPracticeFormPage</code>: Abre la página del formulario.</li>
            <li><code>fillFirstAndLastName</code>: Completa los campos de nombre y apellido.</li>
            <li><code>emailUsuario</code>: Ingresa el correo electrónico.</li>
            <li><code>generoMasculino</code>, <code>generoFemenino</code>, <code>generoOtro</code>: Seleccionan el género.</li>
            <li><code>takeScreenshotWithName</code>: Toma capturas de pantalla.</li>
            <li><code>zoomPagina</code>: Ajusta el zoom de la página.</li>
        </ul>
    </li>
</ul>

<h3>4. Definiciones de Pasos (<code>stepdefinitions</code>)</h3>
<ul>
    <li><strong>PracticeFormStepdefinitios:</strong>
        <ul>
            <li>Contiene métodos anotados con <code>@Given</code>, <code>@When</code>, <code>@Then</code>, etc., para definir el flujo de las pruebas.</li>
            <li>Configura actores y asigna habilidades.</li>
        </ul>
    </li>
</ul>

<h3>5. Interfaz de Usuario (<code>userinterface</code>)</h3>
<ul>
    <li><strong>PracticeFormUserinterface:</strong>
        <ul>
            <li><code>FORM_URL</code>: URL del formulario.</li>
            <li>Targets como <code>FIRST_NAME</code>, <code>LAST_NAME</code>, <code>EMAIL_USER</code>, entre otros.</li>
        </ul>
    </li>
</ul>

<h3>6. Runner (<code>runner</code>)</h3>
<ul>
    <li><strong>TestSuitePracticeFormRunner:</strong>
        <ul>
            <li>Configura las opciones de Cucumber (ruta de archivos <code>features</code>, definiciones de pasos y reportes).</li>
        </ul>
    </li>
</ul>

<h2>Tecnologías Utilizadas</h2>
<ul>
    <li><strong>Serenity BDD:</strong> Framework principal para gestionar pruebas.</li>
    <li><strong>Screenplay Pattern:</strong> Patrón que organiza las pruebas en tareas, interacciones y preguntas.</li>
    <li><strong>Cucumber:</strong> Framework BDD para escribir casos de prueba en lenguaje natural.</li>
    <li><strong>Java:</strong> Lenguaje de programación.</li>
    <li><strong>Selenium WebDriver:</strong> Para la interacción con navegadores.</li>
    <li><strong>JUnit:</strong> Para la ejecución de pruebas.</li>
</ul>

<h2>Requisitos Previos</h2>

<h3>Configuración del Entorno:</h3>
<ul>
    <li>Java 11 o superior.</li>
    <li>Maven instalado.</li>
    <li>Navegador Chrome o Edge con los drivers correspondientes.</li>
</ul>

<h3>Dependencias de Maven:</h3>
<p>Incluya las dependencias necesarias en el archivo <code>pom.xml</code>:</p>

<pre><code>&lt;dependencies&gt;
&lt;dependency&gt;
    &lt;groupId&gt;net.serenity-bdd&lt;/groupId&gt;
    &lt;artifactId&gt;serenity-core&lt;/artifactId&gt;
    &lt;version&gt;3.9.2&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
    &lt;groupId&gt;net.serenity-bdd&lt;/groupId&gt;
    &lt;artifactId&gt;serenity-screenplay&lt;/artifactId&gt;
    &lt;version&gt;3.9.2&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
    &lt;groupId&gt;net.serenity-bdd&lt;/groupId&gt;
    &lt;artifactId&gt;serenity-cucumber6&lt;/artifactId&gt;
    &lt;version&gt;3.9.2&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
    &lt;groupId&gt;io.cucumber&lt;/groupId&gt;
    &lt;artifactId&gt;cucumber-java&lt;/artifactId&gt;
    &lt;version&gt;7.13.0&lt;/version&gt;
&lt;/dependency&gt;

<h2>Configuración de Ejecución</h2>
<h3>Archivos <code>.feature</code>:</h3>
<p>Ubique sus escenarios en la carpeta <code>src/test/resources/features</code>.</p>
<h3>Runner:</h3>
<p>Configure el archivo <code>TestSuitePracticeFormRunner.java</code> para definir las rutas y plugins de Cucumber.</p>
