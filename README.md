# AlertSpockExtension

A sample Spock Extension which issues an alert if a spock test fails.
The basic idea is borrowed from kenspie spock presentation at JavaOne 2014.

It is extended to have a more generic concept of alert with several implementations.

Currently implemented are:

- Say (saying a preconfigured message or the name of the test followed by "failed")
- Play (playing a music file)

The extnesion is applied to a test by using the annotation:
```
@Alert
```
By default this will only use the 'say' alert and call the name of the failing test followed by "failed".

To change those defaults, you can modify the alert types

```
@Alert[PLAY])
```
or 
```
@Alert([SAY, PLAY])
```
or also modify the parameters to those alert implementations, e.g.

```
@Alert(value = [SAY, PLAY], params = ['say:the test failed', 'play:/Users/alanger/dev/alert/anarchyintheuk.m4a'])
```
This will say "The test failed" and then play the music file specificed (in this case 'Anarchy in the UK').

For an example test that uses the Alert extension see:

https://github.com/langera/AlertSpockExtension/blob/master/src/test/groovy/org/langera/spockextensions/alert/Example.groovy

**The current Alerters are using Mac-OSX specific commands and so will only work on a Mac**



