package com.design.wen.pipeline;

interface  Handler<I,O> {
    O process(I input);
}
