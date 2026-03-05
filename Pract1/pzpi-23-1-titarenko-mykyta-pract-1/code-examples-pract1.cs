using System;

OldLogger oldLogger = new OldLogger();
IModernLogger logger = new LoggerAdapter(oldLogger);

logger.Log("Info message", Severity.Info);
logger.Log("Warning message", Severity.Warning);
logger.Log("Error message", Severity.Error);

enum Severity
{
    Info,
    Warning,
    Error
}

class OldLogger
{
    public void LogInfo(string message)
    {
        Console.WriteLine($"INFO: {message}");
    }

    public void LogWarning(string message)
    {
        Console.WriteLine($"WARNING: {message}");
    }

    public void LogError(string message)
    {
        Console.WriteLine($"ERROR: {message}");
    }
}

interface IModernLogger
{
    void Log(string message, Severity severity);
}

class LoggerAdapter : IModernLogger
{
    private readonly OldLogger _oldLogger;

    public LoggerAdapter(OldLogger oldLogger)
    {
        _oldLogger = oldLogger;
    }

    public void Log(string message, Severity severity)
    {
        switch (severity)
        {
            case Severity.Info:
                _oldLogger.LogInfo(message);
                break;
            case Severity.Warning:
                _oldLogger.LogWarning(message);
                break;
            case Severity.Error:
                _oldLogger.LogError(message);
                break;
        }
    }
}