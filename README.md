# Full-Stack-Angular-and-Java-Spring-Boot-E-Commerce

Note: kill $(lsof -t -i:8080)

<h3>Requirements: </h3>
<ul>
    <li>Show list of products</li>
    <li>Add products to shopping cart</li>
    <li>User login/logout security</li>
    <li>Track previous orders for logged in user</li>
</ul>

<h3>Certificates: </h3>
<ul>
    <li>Java provide support for keys and certificates</li>
    <li>A Keystore is a file that contains keys and certificates</li>
    <li>The entries are associated with alias and password</li>
    <li>KeyStore -> alias1 [key and certificate] & alias2 [key and certificate] and ...</li>
    <li>Generate Key and Self Signed Certificate using JdkUtilityTool keytool included with JDK</li>
    <li>Since Java 9, the default keystore format is PKCS12</li>
    <li>We'll use a keystore when we're a server and want to use HTTPS. During an SSL handshake, the server looks up the private key from the keystore, and presents its corresponding public key and certificate to the client.</li>
    <li>A truststore is the opposite. While a keystore typically holds onto certificates that identify us, a truststore holds onto certificates that identify others.</li>
    <li>In Java, we use it to trust the third party we're about to communicate with.</li>
    <li>Take our earlier example. If a client talks to a Java-based server over HTTPS, the server will look up the associated key from its keystore and present the public key and certificate to the client.
    We, the client, then look up the associated certificate in our truststore. If the certificate or Certificate Authorities presented by the external server isn't in our truststore, we'll get an SSLHandshakeException, and the connection won't be set up successfully.</li>
    <li>Java has bundled a truststore called cacerts, and it resides in the $JAVA_HOME/jre/lib/security directory.
    It contains default, trusted Certificate Authorities
    </li>
</ul>