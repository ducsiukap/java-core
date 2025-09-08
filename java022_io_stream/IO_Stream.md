# Java Input / Output Stream

### Flow

```
Source  ---(read)--> Application  ---(write)--->  Destination
```

Sources canbe:

- files
- keyboards
- network  
  v.v..

Destinations:

- files
- sockets
- console  
  v.v..

### Includes:

- [Byte Stream]()
- [Charactor Stream]()
- [Object Stream]()
- [Filtered Data Stream]()

### Hierarchy:

```
java.io (base)
    |
    |___ InputStream (Byte Stream, abstract)
    |       |___ FileInputStream
    |       |___ FilterInputStream
    |       |       |__ BufferedInputStream
    |       |       |__ DataInputStream
    |       |       |__ PushbackInputStream
    |       |___ ObjectInputStream
    |       |___ ByteArrayInputStream
    |       |___ PipedInputStream
    |
    |___ OutputStream (Byte Stream, abstract)
    |       |___ FileOutputStream
    |       |___ FilterOutputStream
    |       |       |__ BufferedOutputStream
    |       |       |__ DataOutputStream
    |       |       |__ PrintStream
    |       |___ ObjectOutputStream
    |       |___ ByteArrayOutputStream
    |       |___ PipedOutputStream
    |
    |
    |___ Reader (Character Stream, abstract)
    |       |___ BufferedReader
    |       |       |___ LineNumberReader
    |       |___ FilterReader
    |       |       |___ PushbackReader
    |       |___ StringReader
    |       |___ CharArrayReader
    |       |___ PipedReader
    |       |___ InputStreamReader
    |               |___ FileReader
    |
    |___ Writer (Character Stream, abstract)
            |___ BufferedWriter
            |___ StringWriter
            |___ FilterWriter
            |___ CharArrayWriter
            |___ PipedWriter
            |___ PrintWriter
            |___ OutputStreamWriter
                    |___ FileWriter
```
