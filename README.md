# AGP ignores android.lint.checkDependencies = false setting

To display the issue, the following command was used:

```bash
./gradlew :app:lintDebug --console=plain | grep lint
```

Output of the following command for this project for AGP 8.2.+:

```
> Task :app:lintAnalyzeDebug
> Task :lib:lintAnalyzeDebug 
> Task :app:lintReportDebug
> Task :app:lintDebug
> Task :app:lint
```

Whereas output of the following command for this project for AGP 8.1.4:

```
> Task :app:lintAnalyzeDebug
> Task :app:lintReportDebug
> Task :app:lintDebug
> Task :app:lint
```
