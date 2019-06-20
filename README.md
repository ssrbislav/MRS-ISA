# MRS-ISA

Predmetni projekat iz predmeta: Internet softverske arhitekture i Metodologije razvoja softvera

Članovi tima:

    Srbislav Stojić SW83-2016

Projektni zadatak

    Realizovati aplikaciju za rezervaciju karata za letove.

Korišćene tehnologije:

    Java + Spring Boot
    REST servisi
    MySql baza podataka
    Angular 7
    Bootstrap

Uputstvo za pokretanje projekta

    Clone/Download projekta sa github-a, link: https://github.com/ssrbislav/MRS-ISA
    
    Da bi se aplikacija pokrenula potrebno je skinuti MySql bazu podataka sa sajta: https://www.mysql.com/downloads/
    Podaca za bazu:
        user: root
        password: root
    Baza se generiše pri pokretanju projekta

    KORACI: (Eclipse IDE specific)
    
    import as
    Existing Maven Project:
    desni klik -> Run as -> Maven clean
    desni klik -> Run as -> Maven build (u goals ukucajte package) Pokretanje projekta:
    desni klik -> Run as -> Spring Boot App
    U fajlu aplication.properties se nalaze podesavanja za aplikaciju:
    spring.datasource.url = jdbc:mysql://localhost:3306/sbvtransport?useSSL=false&createDatabaseIfNotExist=true&
    useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    
    Client side: AirFTN-front:
        otvori se Command prompt (Terminal, PowerShell)
        pozicionira se na putanji projekta
        ukuca je ng serve
        nakon kompajliranja, u pregledaču je potrebno uneti link: http://localhost:4200
    Aplikacije treba da su pokrenute u isto vreme( prvo Spring Boot pa Angular)

DODATNO

    U projektu postoji samo jedan admin koji se sam generiše pri pokretanju projekta
    (username: admin, password:admin)
