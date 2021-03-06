/*
 * Copyright (C) 2020 PatrickKR
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact me on <mailpatrickkr@gmail.com>
 */

package com.github.patrick.inst.command.argument

import com.github.noonmaru.kommand.KommandContext
import com.github.noonmaru.kommand.argument.KommandArgument

internal class RangedIntegerArgument(private val range: IntRange = Int.MIN_VALUE..Int.MAX_VALUE) : KommandArgument<Int> {
    override val parseFailMessage: String
        get() = "${KommandArgument.TOKEN} <-- ${range.first.coerceAtMost(range.last)} ~ ${range.first.coerceAtLeast(range.last)} 범위에 없는 정수 입니다."

    override fun parse(context: KommandContext, param: String): Int? {
        return param.toIntOrNull()?.run {
            if (this in range) this else null
        }
    }
}