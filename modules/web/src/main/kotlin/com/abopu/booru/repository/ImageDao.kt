/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Sarah Skanes
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.abopu.booru.repository

import com.abopu.booru.domain.Image
import com.abopu.data.Criteria
import com.abopu.data.jdbc.dao.AbstractDAO

/**
 * Created: November 20, 2019.
 * @author Sarah Skanes
 */
class ImageDao : AbstractDAO(), ImageRepository {
    
    override fun update(record: Image): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readAll(): MutableCollection<Image> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun create(record: Image): Image {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun read(id: Long): Image {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun read(criteria: Criteria?): MutableCollection<Image> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: Long): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}