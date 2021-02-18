package io.eigr.astreu;

public final class Config {
    private final String host;
    private final int port;
    private final ConnectionOptions options;

    public Config(String host, int port, ConnectionOptions options) {
        this.host = host;
        this.port = port;
        this.options = options;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public ConnectionOptions getOptions() {
        return options;
    }

}
