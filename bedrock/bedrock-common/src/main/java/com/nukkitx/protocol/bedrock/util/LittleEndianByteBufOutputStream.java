package com.nukkitx.protocol.bedrock.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.ByteBufUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LittleEndianByteBufOutputStream extends ByteBufOutputStream {
    private final ByteBuf buffer;

    public LittleEndianByteBufOutputStream(ByteBuf buffer) {
        super(buffer);
        this.buffer = buffer;
    }

    @Override
    public void writeChar(int v) throws IOException {
        this.buffer.writeChar(Character.reverseBytes((char) v));
    }

    @Override
    public void writeDouble(double v) throws IOException {
        this.buffer.writeDoubleLE(v);
    }

    @Override
    public void writeFloat(float v) throws IOException {
        this.buffer.writeFloatLE(v);
    }

    @Override
    public void writeShort(int val) throws IOException {
        this.buffer.writeShortLE(val);
    }

    @Override
    public void writeLong(long val) throws IOException {
        this.buffer.writeLongLE(val);
    }

    @Override
    public void writeInt(int val) throws IOException {
        this.buffer.writeIntLE(val);
    }

    @Override
    public void writeUTF(String string) throws IOException {
        this.writeShort(ByteBufUtil.utf8Bytes(string));
        this.buffer.writeCharSequence(string, StandardCharsets.UTF_8);
    }
}
