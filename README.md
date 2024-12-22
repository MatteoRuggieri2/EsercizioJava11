# Scanner Java

## ScanFileNames

Creare la classe `ScanFileNames` con relativo JUnit di test `ScanFileNamesTest`.
Nella classe `ScanFileNames` è contenuto il seguente metodo:

```java
public String solution(String s)

// s: stringa con elenco di files AAAA-MM-GG size name.ext
```

### Input

Esempio di stringa in input:

```java
"1988-08-29 956 system.zip "                 // OK
+ "1995-10-12 245760 old-photos.tgz "        // no dimensione
+ "1996-04-07 205761 file2.rar "             // no data
+ "1996-04-07 200100 my-image.jpg "          // no est. errata
+ "1989-11-05 208261 file6. "                // no suffix
+ "1988-11-05 400 file1 "                    // no estensione
+ "1994-12-01 845 very-long-filename.rar ";  // OK
```

### Output

Il _**conteggio dei file**_ o "_**NO FILES**_" in caso non fossero presenti.
Conteggia solo i file **precedenti** al **13 Ottobre 1995**

Ritorna "INPUT INVALID" in questi casi:

- Se size > 240K (240000)
- Se non c'è estensione (.)
- Se non c'è suffix dopo .
- Se suffix diverso da rar, zip, tgz

Esempio di creazione oggetto LocalDate

```java
int yyyy = Integer.parseInt(date.substring(0, 4));
int mm = Integer.parseInt(date.substring(5, 7));
int dd = Integer.parseInt(date.substring(8));
LocalDate curDate = LocalDate.of(yyyy, mm, dd);
```

Consiglio per il confronto delle date:
Usa `LocalDate.of(yyy,mm,gg)` per creare una data e `LocalDate.iBefore()` per confrontarla.
