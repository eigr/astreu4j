package io.eigr.astreu;

import io.eigr.astreu.protocol.Exchange;

public interface SubscriptionContext extends Context {
    void accept();
    void reject();
    void reply(Exchange exchange) throws NotMessageCorrelationException;
}
