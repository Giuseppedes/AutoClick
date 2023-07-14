# AutoClick
Tool per click automatico.

Utile strumento di supporto all'apprendimento per i corsi on line che richiedono di cliccare il pulsante "AVANTI" dopo ogni video e permettono il click soltanto quando il video è terminato.

Utilizzando questa semplice applicazione ci si può concentrare completamente sul video-corso, senza distrarsi per muovere il mouse e cliccare sul pulsante avanti.

## Istruzioni
1. Avviare il programma;
1. puntare il mouse sulla progress bar che indica l'avanzamento del video;
3. attendere 3 secondi e puntare il pulsante che permette di proseguire con il video successivo.

## Issue
Instead of current page I got a image only containing my desktop's background:

The problem was MacOS permission. The program needs permission to record the screen. 
I simply added the access to IntelliJ in System Preferences -> Security and Privacy -> Privacy -> Screen Recording and it worked.

do the same for Accessibility

### TODO
* Sostituire il wait con l'attesa di un click per ottenere la posizione dei due elementi.
* Creare un' interfaccia che permetta di mettere in pausa e di riprendere l'esecuzione.
